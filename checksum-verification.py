#DEEPTHI B-21BCE5601

#get number of inputs from user
n=int(input())

temp=0

#get n inputs and add them
for i in range(n):
    binaryword=input()
    temp+=int(binaryword,2)

#accept checksum received from sender
checksumin=int(input(),2)

#add carry to temp, if any
while temp>255:
    carry=temp>>8
    temp&=0xFF
    temp+=carry

#take 1's complement of x
x=(~temp)&0xFF

if(x==checksumin):
    print("Error free")
else:
    print("Error")
