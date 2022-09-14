object MercatorTest{

	def main(args: Array[String]): Unit = {
		var output = totalCost(Array("Apple", "Apple", "Orange", "Apple")) //sample test
		Console.printf(output.toString())
		output = totalCost(Array("Orange")) //Testing each individually
		Console.printf(output.toString())
		output = totalCost(Array("Apple"))
		Console.printf(output.toString())
		output = totalCost(Array("Apple", "Other", "Orange")) //Invalid input
		Console.printf(output.toString())
		output = totalCost(Array("Orange", "Orange", "Apple", "Apple", "Orange")) //Testing both offers at once
		Console.printf(output.toString())
		output = totalCost(Array()) //Empty input
		Console.printf(output.toString())
	}

	def totalCost(list: Array[String]) : Double = {
		var count=0; var apples=0; var oranges=0; var invalidEntry=false;
		while (count<list.size){ //we iterate through the list
			val word = list(count)
			if (word == "Apple") apples=apples+1 //and iterate the correct variable
			else 
				if (word == "Orange") oranges=oranges+1 
				else invalidEntry=true //if we encounter anything other than apples and oranges, we mark the input as invalid

			count = count+1
		}
		if (invalidEntry) -1 else { //if the input is invalud we return -1, otherwise:
			if (apples%2 == 0) apples = apples/2 //apples were 2 for 1, so we multiply the apple price by half as much
			else {apples = apples-1; apples = apples/2; apples = apples+1} //I wasn't sure if I was allowed to import math.round, so this is how i preserved the remainder while staying in integer arithmetic

			val remainder = oranges%3
			oranges = 2 * ((oranges-remainder)/3) + remainder //I did the same here but multiplying the oranges by 2/3, saving the remainder
			apples*0.6+oranges*0.25 //then we calculate and return the final price
		}
	}

}