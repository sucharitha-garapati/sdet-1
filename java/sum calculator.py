Mylist = list(input("Enter a sequence of comma separated values: ").split(","))
sum = 0
for number in Mylist:
  sum += int(number)
print(sum)