def findItem(nestedArr, flatArr):
	for item in nestedArr:
		if type(item) == type([]):
			findItem(item, flatArr)
		else:
			flatArr.append(item)
	return flatArr

if __name__ == "__main__":
	nestedArr = [[1,2,[3]],4,[7,8,[8,76,[66]]]]
	flatArr = []
	print (findItem(nestedArr, flatArr))
