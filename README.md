# Courier Kata

##Description
You work for a courier company and have been tasked with creating a code library to
calculate the cost of sending an order of parcels.

## Implementation Steps
1) The initial implementation just needs to take into account a parcel's size. For each size
type there is a fixed delivery cost
- Small parcel: all dimensions < 10cm. Cost $3
- Medium parcel: all dimensions < 50cm. Cost $8
- Large parcel: all dimensions < 100cm. Cost $15
- XL parcel: any dimension >= 100cm. Cost $25
2) Thanks to logistics improvements we can deliver parcels faster. This means we can
charge more money. Speedy shipping can be selected by the user to take advantage of our
improvements.
- This doubles the cost of the entire order
- Speedy shipping should be listed as a separate item in the output, with its associated
cost
- Speedy shipping should not impact the price of individual parcels, i.e. their individual
cost should remain the same as it was before
3) There have been complaints from delivery drivers that people are taking advantage of our
dimension only shipping costs. A new weight limit has been added for each parcel type, over
which a charge per kg of weight applies
+$2/kg over weight limit for parcel size:

- Small parcel: 1kg
- Medium parcel: 3kg
- Large parcel: 6kg
- XL parcel: 10kg
4) Some of the extra weight charges for certain goods were excessive. A new parcel type
has been added to try and address overweight parcels
Heavy parcel (limit 50kg), $50. +$1/kg over
5) In order to award those who send multiple parcels, special discounts have been
introduced.
- Small parcel mania! Every 4th small parcel in an order is free!
- Medium parcel mania! Every 3rd medium parcel in an order is free!
- Mixed parcel mania! Every 5th parcel in an order is free!
- Each parcel can only be used in a discount once
- Within each discount, the cheapest parcel is the free one
- The combination of discounts which saves the most money should be selected every
time
Example:
6x medium parcel. 3 x $8, 3x $10. 1st discount should include all 3 $8 parcels and save $8.
2nd discount should include all 3 $10 parcels and save $10.
- Just like speedy shipping, discounts should be listed as a separate item in the output,
with associated saving, e.g. "-2"
- Discounts should not impact the price of individual parcels, i.e. their individual cost
should remain the same as it was before
- Speedy shipping applies after discounts are taken into account

## My Approach
1. I decided to approach this problem using Java as it is a language I'm quite familiar with and the language where I know the most about object-oriented programming
I started by trying to see what objects I would need to allow for a basic Parcel to be classified and have an associated cost. I decided to have the main parcel object, a parcel dimensions object, and a parcel type object for classification
I would pass the dimensions in to a parcel object, and create a dimensions object with that, and then a type object based on the dimensions to classify the parcel. Finally a method for determining cost was made inside parcel.java
2. For speedy shipping I initially decided to make it a boolean parameter in the Parcel object, and in the setRate method, would double the total cost if speedy was true, and kept a sperate field speedyCost to list as a seperate cost on the order.
3. For weight limits I revised the ParcelType object and added the weight limit based on the type. In Parcel.java I added a method to calculate how many kg overweight a parcel was and store how much extra it would cost in a field overweightCost.
Then overweight cost was added into the totalCost calculation.
4. For the heavy parcel a new type was added into the ParcelType object for whenever weight>50. The overweight function in Parcel was also revised to account for the difference in overweight charges for heavy parcels.
5. For the final task I realized I needed to create an Order object as well for multiple parcels. So an order object was created that took an array of Parcels. The Order constructor now set the rate for the parcel, and summed the parcel costs to add to the order total.
I also changed speedy shipping, realizing that applying it to individual parcels didnt make sense, now it was an optional parameter for the Order object where if True, it doubles the entire Order cost. A function was also added to print out the individual parcel costs and speedy shipping costs if applicable.

## Example Order
```java
Parcel[] p = {new Parcel(10, 4, 52, 6), new Parcel(18, 18, 18, 2), new Parcel(10, 4, 42, 52)};
Order o = new Order(p, true);
o.printOrder();
```     
This creates an array of 3 parcels with given height, width, lengths, and weights, creates an order for those 3 parcels with speedy shipping and prints the total cost.
## Output
Parcel 1 Cost: 15.0 <br />
Parcel 2 Cost: 8.0 <br />
Parcel 3 Cost: 52.0 <br />
Speedy Cost: 75.0 <br />
Order Total: 150.0 <br />


## Future Steps
5. After setting up the Order file I was running out of time, and spent the rest of my time ensuring everything was running correctly. To add in the discounts I would have created a CalcualteDiscounts() function to determine the necessary discounts and add it to sepearte field and subtract it from the title.
To do this would likely have required a bit more thinking but my initial thought process was that based on the example, where there are 6 mediums 8,8,8,10,10,10 and one 8 and one 10 are discounted (instead of two 8s, which is cheaper), that the parcels would need to be grouped together and sorted in ascending order.
Commented out is some code I didn't finish for this method, where the array is sorted in ascneding order from cheapest to most expensive. From here I would make a method that would look through this sorted array to find a 4th small, 3rd medium, etc. and iterate a discount field, which would then get subtracted from the order total.

##Reflections
- Working from an Order object to begin with definitely would have saved me some time at the end where I could have worked towards getting the discounts implemented, rather than scrambling to get it implemented correctly, probably my biggest initial oversight
- I would have also have liked to do a lot more exception handling and making sure that any potential unexpected inputs would be handled appropriately, but I wanted to foucs on on the core implementation first before working with edge cases and ran out of time.
- Field and variable names have a good bit of overlap and could probably do with a bit of variation and be made more unique than they currently are
- Keeping all class fields private and using getters definitely got tedious doing it continuously and I do wonder how necessary it really was but given how generic some of my variable names did tend to get I wanted to make sure there was little room for confusion
