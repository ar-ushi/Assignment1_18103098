// Balancing Parantheses is a stack problem so declare a stack to hold all the opening brackets such as {, (, [ and traverse the string - if opening character then push to stack, if closing, pop from stack and check if matching


const BalancedBrackets = function(str){
    var stack = [];
    var map = {
        '(': ')',
        '{': '}',
        '[' : ']'
    }

    for( i = 0; i<str.length; i++){
        if (str[i] === '(' || str[i] === '{' || str[i] === '[')
            stack.push(str[i]);      
        else{
            var last = stack.pop();
            if (str[i] !== map[last])
                return false;
        }
    }
    if (stack.length !== 0)
    return false;
    return true;
}

console.log(BalancedBrackets("{[]()}"))
console.log(BalancedBrackets("{[(])}"))
console.log(BalancedBrackets("{[}"))