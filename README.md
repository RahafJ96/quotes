# quotes

This app shows random popular book quotes with the author name, It chooses one quote each time it is run. And I used GSON to parse the .json file.


## Lab09 QuoteAPI
- In this lab I create a new class called  `ApiQuote` to structure the data that comes from the API.

- I did not use any new methods, but what I do is create a new `ApiQuote` variable to store the data that come from the API, then create `Quote` to generate a new quote and using the getter method from `ApiQuote` to fill the text and author. the code bellows explain the idea:

```
 ApiQuote qutApi = gson.fromJson(bufferedReader,ApiQuote.class);
 Quotes quotLocal = new Quotes(null, qutApi.getAuthor(), null,qutApi.getQuote());

 ```

- After that I add the new quote to the `List<Quotes>` which means it added to the json file.