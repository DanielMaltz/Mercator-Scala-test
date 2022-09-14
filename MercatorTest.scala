object MercatorTest{

	def main(args: Array[String]): Unit = {
		var output = totalCost(Array("Apple", "Apple", "Orange", "Apple"))
		Console.printf(output.toString())
		output = totalCost(Array("Orange"))
		Console.printf(output.toString())
		output = totalCost(Array("Apple", "Other", "Orange"))
		Console.printf(output.toString())
	}

	def totalCost(list: Array[String]) : Double = {
		var count=0; var apples=0; var oranges=0; var invalidEntry=false;
		while (count<list.size){
			val word = list(count)
			if (word == "Apple") apples=apples+1
			else 
				if (word == "Orange") oranges=oranges+1
				else invalidEntry=true

			count = count+1
		}
		if (invalidEntry) -1 else apples*0.6+oranges*0.25
	}

}