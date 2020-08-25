from random import randint

def inpu():
    a = randint(0, 50)
    b = randint(0, 50)

    if a > b:
        a, b = b, a
    elif a == b:
        b += 1

    for i in range(0, 50):
        if i >= a and i <= b:
            print("#", end = "")
        else:
            print(" ", end = "")
    print()  
    return str(a)+" "+str(b)

ints = list()
num = 10

for i in range(num):
    cur = inpu()
    temp = cur.split()

    temp[0] = int(temp[0])
    temp[1] = int(temp[1])

    ints.append([temp[1],temp[0]])

ints.sort()

l = len(ints)
tim = 0
vacs = 0
max_vacs = -1
left = -1
pers = 0
old = -1

for j in range(l):
    if max_vacs > (l - j):
        break
    if ints[j][0] == old:
        continue
    
    for i in range(j, l):
        if ints[i][1] <= ints[j][0]:
            vacs += 1    
            if ints[i][1] > left:
                left = ints[i][1]
                
    if vacs > max_vacs:
        max_vacs = vacs
        tim = 0
        pers = 0
    if vacs == max_vacs:
        tim += ints[j][0] - left + 1
        pers += 1
        
    old = ints[j][0]
    left = -1
    vacs = 0
    
print(pers, tim)
