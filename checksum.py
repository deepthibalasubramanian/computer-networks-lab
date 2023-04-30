#DEEPTHI B - 21BCE5601

#get number of inputs from user
n=int(input())

#initialize an array to hold user inputs
arr=[]

#get n inputs from user and store in arr
for i in range(n):
    arr.append(input())

#temp=0
temp='0x0000'

#add all the elements in arr, and store sum in temp
for i in range(n):
    temp=hex(int(temp,16)+int(arr[i],16))
    
#find the length of temp.
#hexa is of format 0xpqrs, where, pqrs denote hexa values
#while considering, we eliminate the 0x part
#ideal length for 16 bit hexa is 6 (i.e., 2 for 0x, and 4 for pqrs)
#if the length of temp is greater than 6, you need to extract the 
#leading extra bits and add to trail of the hexa number
#store the sum in x
z=len(temp)
a=temp[2:(z-4)]
b=temp[(z-4):]
x=int(a,16)+int(b,16)

#take 1's complement of x
x=~x
y=hex(x&0xFFFF)[2:]
y=y.upper()
print(y)
