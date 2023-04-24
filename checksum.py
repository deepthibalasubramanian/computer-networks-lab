#created on 24.4.23

arr=["4500","003C","1C46","4000","4006","0000","AC10","0A63","AC10","0A0C"]
n=10
temp="4500"
for i in range(1,n):
    temp=hex(int(temp,16)+int(arr[i],16))
print(temp[2:])

x=hex(int("4e17",16)+int("2",16))
y=hex(int(x,16)+int("0xff",16))
print(y)



arr=["4500","003C","1C46","4000","4006","0000","AC10","0A63","AC10","0A0C"]
n=10
temp="4500"
for i in range(1,n):
    temp=hex(int(temp,16)+int(arr[i],16))
print(temp[2:])
print(len(temp))

x=hex(int(temp[2],16)+int(temp[3:],16))
#y=hex(int(x,16)+int("0xff",16))
print(x)



