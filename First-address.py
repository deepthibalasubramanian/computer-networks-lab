# given:
# IP address
# net mask
# to find:
# network address
# last address
# total devices

ipaddress=input()
array=ipaddress.split('.')
array2=array[-1].split('/')
print(array2)
array.extend(array2)
print(array)
netmask=int(array[-1])
hostaddress=32-netmask
print("Number of devices: "+str(2**hostaddress))
