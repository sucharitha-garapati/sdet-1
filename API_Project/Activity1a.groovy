package groovy_activities

class Activity1a {
	 static void main(def args) {
		def inputList = [11,2,19,5,"mango","Apple","watermelon"]
		def sortedIntList = inputList.minus(["mango","Apple","watermelon"])
		println "Sorted Integer List:" + sortedIntList.sort()
		def sortedStringList = inputList.minus([11,2,19,5])
		println "Sorted String List:" + sortedStringList.sort()
	}
}
