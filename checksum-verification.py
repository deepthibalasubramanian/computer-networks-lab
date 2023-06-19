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
print(array)

# network address
# decimal to binary
#bin(n).replace("0b", "")
array1=[]
netmask=int(array[-1])
hostaddress=32-netmask
totaldevice=2**hostaddress

#format(x, '08b')
for i in array:
    #x=(bin(int(i)).replace("0b", ""))
    y=format(int(i),'08b')
    array1.append(y)
    '''while int(bin(array1[-1]))<128:
        array1[-1]=bin('0'+str(array1[i])).replace('0b', '')'''
print(array1)

'''if(netmask<9):
    
elif (netmask<17):

elif(netmask<25):
    
elif(netmask<33):

else:'''


# total devices
print("Number of devices: "+str(totaldevice))
