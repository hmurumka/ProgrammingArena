package practice.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * Molecule Weight Calculator
Data Structures & Algorithms
Given atomic weights for three atoms (C = 12, H = 1, O = 8) and a chemical formula string, 
compute the total molecular weight.

Examples:

CH4 = 16
H(CH4)2 = 33
The candidate used a stack‑based approach to handle nested parentheses and multipliers.
 */
public class MoleculeWeightCalculator {

    public static void main(String[] args) {
        MoleculeWeightCalculator o = new MoleculeWeightCalculator();
        Stack<Character> stack = new Stack<>();
        System.out.println(o.calculate("H(CH4)2", stack));
    }

    private int calculate(String formula, Stack<Character> st)
    {
        if(Objects.isNull(formula) || formula.isBlank() || formula.isEmpty())
            return 0;

        for(Character c : formula.toCharArray())
            st.push(c);

        Character ch;
        int weight = 0;
        while(!st.isEmpty()){
            ch = st.pop();
            weight += getMoleculeWeight(ch, st);
        }

        return weight;
    }

    private int getMoleculeWeight(Character ch, Stack<Character> stk)
    {
        int ret = 0;
        switch (ch) {
            case 'C':
                ret = 12;
                break;
            case 'H':
                ret = 1;
                break;
            case 'O':
                ret = 16;
                break;
            default : // handle numeric case and '(' & ')'
                if(ch == ')')
                {
                    Character ch1;
                    while((ch1 = stk.pop()) != '(')
                    ret += getMoleculeWeight(ch1, stk);
                }
                else
                {
                    if(!stk.isEmpty())
                    ret = Character.getNumericValue(ch) * getMoleculeWeight(stk.pop(), stk);
                }
                break;
        }

        return ret;
    }

}
