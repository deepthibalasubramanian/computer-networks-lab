# given:
# IP address
# net mask
# to find:
# network address: first address
# last address
# total devices

# idea: convert all binary values into 8 bit format
# join them together
# find subnet mask in binary
# do AND for first address
# take 1's complement and OR for last address


ipaddress=input()
array=ipaddress.split('.')
array2=array[-1].split('/')
#print(array2)
array.pop()
array.extend(array2)
#print(array)

# network address
# decimal to binary
#bin(n).replace("0b", "")
array1=[]
netmask=int(array[-1])
hostaddress=32-netmask
totaldevice=2**hostaddress
inputset=''
array3=array
array.pop()
#format(x, '08b')
for i in array:
    #x=(bin(int(i)).replace("0b", ""))
    y=format(int(i),'08b')
    array1.append(y)
    inputset=inputset+y
#print(array1)
#print(inputset)
subnet=''
for i in range(int(netmask)):
    subnet=subnet+'1'
for i in range(int(hostaddress)):
    subnet=subnet+'0'
#print(subnet)
firstaddbin=''

for i in range(32):
    firstaddbin+=str(int(subnet[i])&int(inputset[i]))
#firstaddbin=bin(subnet)&int(inputset)
#print(firstaddbin)
firstaddress=(str(int(firstaddbin[:8],2))+'.'+str(int(firstaddbin[8:16],2))+'.'+str(int(firstaddbin[16:24],2))+'.'+str(int(firstaddbin[24:32],2)))
print(firstaddress)
compsubnet=''

#last address
for i in range(32):
    if(subnet[i]=='0'):
        compsubnet+='1'
    else:
        compsubnet+='0'
#print(compsubnet)
lastaddbin=''
for i in range(32):
    lastaddbin+=str(int(compsubnet[i])|int(inputset[i]))
lastaddress=(str(int(lastaddbin[:8],2))+'.'+str(int(lastaddbin[8:16],2))+'.'+str(int(lastaddbin[16:24],2))+'.'+str(int(lastaddbin[24:32],2)))
print(lastaddress)

# total devices
print(str(totaldevice))
