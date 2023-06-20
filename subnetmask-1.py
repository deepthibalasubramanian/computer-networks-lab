import math
ipaddress=input()
array=ipaddress.split('.')
array2=array[-1].split('/')
array.pop()
array.extend(array2)
#print(array)

subnetnum=int(input())
numbits=0
while 2**numbits<subnetnum:
    numbits+=1

hostbits=int(array[-1])+numbits
ans=''
for i in range(hostbits):
    ans+='1'
for i in range(32-hostbits):
    ans+='0'
print(str(int(ans[:8],2))+'.'+str(int(ans[8:16],2))+'.'+str(int(ans[16:24],2))+'.'+str(int(ans[24:32],2)))

numofdevices=2**(32-hostbits)
print(numofdevices)
