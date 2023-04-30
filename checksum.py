#created on 24.4.23
n=int(input())
arr=[]
for i in range(n):
    arr.append(input())
temp='0x0000'
for i in range(n):
    temp=hex(int(temp,16)+int(arr[i],16))
z=len(temp)
a=temp[2:(z-4)]
b=temp[(z-4):]

x=int(a,16)+int(b,16)
x=~x
y=hex(x&0xFFFF)[2:]
print(y)
