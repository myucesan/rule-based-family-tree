import com.github.cschen1205.ess.engine.*;

import java.util.Vector;

public class Main {

    private static RuleInferenceEngine getInferenceEngineFamilyTree()
    {
        RuleInferenceEngine rie=new KieRuleInferenceEngine();

        Rule rule=new Rule("Father");
        rule.addAntecedent(new EqualsClause("hasChildren", "yes"));
        rule.addAntecedent(new EqualsClause("gender", "male"));
        rule.setConsequent(new EqualsClause("relation", "Father"));
        rie.addRule(rule);

        rule=new Rule("Mother");
        rule.addAntecedent(new EqualsClause("hasChildren", "yes"));
        rule.addAntecedent(new EqualsClause("gender", "female"));
        rule.setConsequent(new EqualsClause("relation", "Mother"));
        rie.addRule(rule);

        rule=new Rule("Daughter");
        rule.addAntecedent(new EqualsClause("gender", "female"));
        rule.addAntecedent(new EqualsClause("hasParent", "yes"));
        rule.setConsequent(new EqualsClause("relation", "daughter"));
        rie.addRule(rule);

        rule=new Rule("Son");
        rule.addAntecedent(new EqualsClause("gender", "male"));
        rule.addAntecedent(new EqualsClause("hasParent", "yes"));
        rule.setConsequent(new EqualsClause("relation", "son"));
        rie.addRule(rule);

        rule=new Rule("Brother");
        rule.addAntecedent(new EqualsClause("hasSibling", "yes"));
        rule.addAntecedent(new EqualsClause("gender", "male"));
        rule.setConsequent(new EqualsClause("relation", "Brother"));
        rie.addRule(rule);

        rule=new Rule("Sister");
        rule.addAntecedent(new EqualsClause("hasSibling", "yes"));
        rule.addAntecedent(new EqualsClause("gender", "female"));
        rule.setConsequent(new EqualsClause("relation", "Sister"));
        rie.addRule(rule);


        rule=new Rule("Uncle");
        rule.addAntecedent(new EqualsClause("hasSibling", "yes"));
        rule.addAntecedent(new EqualsClause("hasNibling", "yes"));
        rule.setConsequent(new EqualsClause("relation", "Uncle/Aunt"));
        rie.addRule(rule);

        rule=new Rule("Nibling");
        rule.addAntecedent(new EqualsClause("hasUncleAndOrAunt", "yes"));
        rule.setConsequent(new EqualsClause("relation", "Nibling"));
        rie.addRule(rule);

        return rie;
    }

    public static void doInferFC()
    {
        RuleInferenceEngine rie=getInferenceEngineFamilyTree();
        rie.addFact(new EqualsClause("gender", "female"));
        rie.addFact(new EqualsClause("hasSibling", "yes"));
        rie.addFact(new EqualsClause("hasParent", "yes"));

        System.out.println("before inference");
        System.out.println(rie.getFacts());
        System.out.println();

        rie.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(rie.getFacts());
        System.out.println();
    }

    public static void doInferBC()
    {
        RuleInferenceEngine rie=getInferenceEngineFamilyTree();
        rie.addFact(new EqualsClause("gender", "female"));
        rie.addFact(new EqualsClause("hasSibling", "yes"));
        rie.addFact(new EqualsClause("hasParent", "yes"));

        System.out.println("Infer: family relation");

        Vector<Clause> unproved_conditions= new Vector<Clause>();

        Clause conclusion=rie.infer("relation", unproved_conditions);

        System.out.println("Conclusion: "+conclusion);
    }


    public static void main(String[] args) {
        doInferBC();
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________");

    }
}
