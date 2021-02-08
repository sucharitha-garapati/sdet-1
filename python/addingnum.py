def adding_num(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum
numList = [10, 40, 60, 90]
result = adding_num(numList)
print("The sum of all the elements is: " + str(result))