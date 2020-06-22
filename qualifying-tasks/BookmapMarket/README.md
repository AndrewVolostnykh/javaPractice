* Input file
```
There is a text file with:
updates to the limit order book in the following format:
u,<price>,<size>,bid - set bid size at <price> to <size> (<size> shares in total are now being offered at
<price>)
u,<price>,<size>,ask - set ask size at <price> to <size>
queries in the following format:
q,best_bid - print best bid price and size
q,best_ask - print best ask price and size
q,size,<price> - print size at specified price (bid, ask or spread).
and market orders in the following format:
o,buy,<size> - removes <size> shares out of asks, most cheap ones.
o,sell,<size> - removes <size> shares out of bids, most expensive ones.
In case of a buy order this is similar to going to a market (assuming that you want to buy <size> similar
items there, and that all instances have identical quality, so price is the only factor) - you buy <size>
units at the cheapest price available.
Queries, market orders, and limit order book updates are in arbitrary sequence. Each line in the file is
either one of the three and ends with newline character.
Example of input file:
u,9,1,bid
u,11,5,ask
q,best_bid
u,10,2,bid
q,best_bid
o,sell,1
q,size,10
```

* Output file
```
Example of output file (for this input file):
9,1
10,2
1
Please, follow output format as closely as possible.
```
