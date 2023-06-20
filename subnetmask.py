# input:
# ip address with mask
# number of devices
# output:
# subnet mask

import math
ipaddress=input()
array=ipaddress.split('.')
array2=array[-1].split('/')
array.pop()
array.extend(array2)
#print(array)

numdevices=int(input())
subnetbits=int(math.log2(numdevices))
netadd=32-subnetbits
output=''
for i in range(netadd):
    output+='1'
for i in range(32-netadd):
    output+='0'
print(str(int(output[:8],2))+'.'+str(int(output[8:16],2))+'.'+str(int(output[16:24],2))+'.'+str(int(output[24:32],2)))
