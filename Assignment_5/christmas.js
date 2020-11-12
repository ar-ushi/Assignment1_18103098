
//for 10 rows 
i=h=9;
a=new Array(h);
a[0]=a.join(' ');
b=a.join('000');
a[0]+='*';
while(i)
a[i--]=b.substr(i,h+i);
console.log(a.join('\n'))
