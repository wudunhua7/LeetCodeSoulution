package com.leetcode.string;

import java.util.Stack;

/**
 * Created by dun on 2020/4/6.
 */
public class ValidExpress20 {

    public static void main(String[] args) {
        ValidExpress20 validExpress20 = new ValidExpress20();
        validExpress20.isValid("(){}[]");
    }

    /**
     * 20. 有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

     有效字符串需满足：

     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。

     示例 1:

     输入: "()"
     输出: true
     示例 2:

     输入: "()[]{}"
     输出: true
     示例 3:

     输入: "(]"
     输出: false
     示例 4:

     输入: "([)]"
     输出: false
     示例 5:

     输入: "{[]}"
     输出: true

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/valid-parentheses
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s==null||s.length()==0) return true;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            switch(current){
                case '(':
                case '[':
                case '{':
                    stack.push(current);
                    continue;
                default : break;
            }

            if(stack.isEmpty()) return false;
            switch(current){
                case ')':
                    if(stack.pop()=='(') continue;
                    else return false;
                case '}':
                    if(stack.pop()=='{') continue;
                    else return false;
                case ']':
                    if(stack.pop()=='[') continue;
                    else return false;
                default: break;
            }
        }

        return stack.isEmpty();
    }
}
