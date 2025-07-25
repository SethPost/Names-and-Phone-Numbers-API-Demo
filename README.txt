SETH POST - USERS AND PHONE NUMBERS API DEMO

*Overview*
This API can be used to search through a database of 202 users.

Each user has a User ID, a Name, and a Phone Number.

The API endpoint is http://localhost:8080/users.

The API endpoint accepts GET requests and the following search parameters:

	- a String searchQuery that searches for user names that contain the
	  searchQuery in any capacity, case-insensitive. Defaults to an empty String
	  if no value is submitted.
	
	- a String sortIndication that sorts results alphabetically by name
	  if the value of the String is "Alphabetical" and reverse alphabetically
	  if the value is "Reverse Alphabetical". Any other value (and by default)
	  will sort the results by the users' user IDs (ascending). Defaults to
	  an empty String if no value is submitted.

	- an int pageSize. This value indicates the number of users 
	  that will be retrieved per page by the search. If this value is less
	  than 1, it will be set to 1. If it is greater than 50, it will be set
	  to 50. If it is greater than the number of results retrieved, it will be set
	  to that number if it is less than 50. Defaults to 50 if no value is submitted.

	- an int pageNumber. This value indicates the page number of results to be
	  retrieved. The server initially finds all users by searchQuery and
	  sortIndication, then takes that list and divides it into pages based
	  on the value of pageSize. If this value is greater than the number of pages
	  found by the search, it will be set to the last page of the search.
	  Defaults to 1 if no value is submitted.

After submitting the GET request with any parameters included, the API will return a JSON
list of users. It will only return 1 page of the search and a maximum of 50 users.

*Examples*

1. No parameters provided

Result: 

[
    {
        "userId": 1,
        "name": "Seth Post",
        "phoneNumber": "3308073006"
    },
    {
        "userId": 2,
        "name": "John Doe",
        "phoneNumber": "1234567890"
    },
    {
        "userId": 3,
        "name": "Fitz Stitcher",
        "phoneNumber": "2148997923"
    },
    {
        "userId": 4,
        "name": "Darcy McInulty",
        "phoneNumber": "5992296329"
    },
    {
        "userId": 5,
        "name": "Lenka Rathe",
        "phoneNumber": "1747607603"
    },
    {
        "userId": 6,
        "name": "Nisse Fenix",
        "phoneNumber": "1672149430"
    },
    {
        "userId": 7,
        "name": "Roddie Boram",
        "phoneNumber": "1639135476"
    },
    {
        "userId": 8,
        "name": "Jo-anne Danher",
        "phoneNumber": "2052230194"
    },
    {
        "userId": 9,
        "name": "Cilka Haddacks",
        "phoneNumber": "5583741538"
    },
    {
        "userId": 10,
        "name": "Gordie Keer",
        "phoneNumber": "8676980371"
    },
    {
        "userId": 11,
        "name": "Meridel Lisimore",
        "phoneNumber": "4593496211"
    },
    {
        "userId": 12,
        "name": "Haleigh Glyde",
        "phoneNumber": "4849390042"
    },
    {
        "userId": 13,
        "name": "Casi MacCole",
        "phoneNumber": "5726680400"
    },
    {
        "userId": 14,
        "name": "Heidie Standbrooke",
        "phoneNumber": "2956751121"
    },
    {
        "userId": 15,
        "name": "Deni Mengue",
        "phoneNumber": "6504430702"
    },
    {
        "userId": 16,
        "name": "Daisi Pleasance",
        "phoneNumber": "4859276479"
    },
    {
        "userId": 17,
        "name": "Kendal Grayne",
        "phoneNumber": "5975013292"
    },
    {
        "userId": 18,
        "name": "Laural Gallaway",
        "phoneNumber": "5637845571"
    },
    {
        "userId": 19,
        "name": "Lynett Ales0",
        "phoneNumber": "8707998856"
    },
    {
        "userId": 20,
        "name": "Venus Greim",
        "phoneNumber": "7937725635"
    },
    {
        "userId": 21,
        "name": "Janith Puddephatt",
        "phoneNumber": "7624979702"
    },
    {
        "userId": 22,
        "name": "Tod Pidgeley",
        "phoneNumber": "1625930932"
    },
    {
        "userId": 23,
        "name": "Maximilien Willbond",
        "phoneNumber": "8782211085"
    },
    {
        "userId": 24,
        "name": "Luise McMennum",
        "phoneNumber": "4646623900"
    },
    {
        "userId": 25,
        "name": "Ansel Pinilla",
        "phoneNumber": "6478438473"
    },
    {
        "userId": 26,
        "name": "Pia Beagin",
        "phoneNumber": "6852209891"
    },
    {
        "userId": 27,
        "name": "Bernice McFall",
        "phoneNumber": "6909421930"
    },
    {
        "userId": 28,
        "name": "Sukey Oldroyde",
        "phoneNumber": "6568469842"
    },
    {
        "userId": 29,
        "name": "Sibelle Klimentyonok",
        "phoneNumber": "7029454682"
    },
    {
        "userId": 30,
        "name": "Christoph Bengough",
        "phoneNumber": "3059303778"
    },
    {
        "userId": 31,
        "name": "Gillian Oger",
        "phoneNumber": "5481532153"
    },
    {
        "userId": 32,
        "name": "Orin Bearblock",
        "phoneNumber": "1502526360"
    },
    {
        "userId": 33,
        "name": "Lydie Lared",
        "phoneNumber": "3418824713"
    },
    {
        "userId": 34,
        "name": "Willette Biasini",
        "phoneNumber": "6319469654"
    },
    {
        "userId": 35,
        "name": "Chandal Debold",
        "phoneNumber": "5248075377"
    },
    {
        "userId": 36,
        "name": "Willow Rosekilly",
        "phoneNumber": "9204978017"
    },
    {
        "userId": 37,
        "name": "Emilio Yakunikov",
        "phoneNumber": "1392135743"
    },
    {
        "userId": 38,
        "name": "Britt Adolf",
        "phoneNumber": "4872260688"
    },
    {
        "userId": 39,
        "name": "Jerrilyn Brereton",
        "phoneNumber": "2911799019"
    },
    {
        "userId": 40,
        "name": "Yorker Moxham",
        "phoneNumber": "8021860660"
    },
    {
        "userId": 41,
        "name": "Eberhard Hasted",
        "phoneNumber": "5241875315"
    },
    {
        "userId": 42,
        "name": "Cori Pocknell",
        "phoneNumber": "1988644436"
    },
    {
        "userId": 43,
        "name": "Teodora Dullaghan",
        "phoneNumber": "7322440636"
    },
    {
        "userId": 44,
        "name": "Veronica Hucker",
        "phoneNumber": "5741998195"
    },
    {
        "userId": 45,
        "name": "Addy Littrik",
        "phoneNumber": "3899635231"
    },
    {
        "userId": 46,
        "name": "Brenn McGaughie",
        "phoneNumber": "7173221114"
    },
    {
        "userId": 47,
        "name": "Bastian Brosoli",
        "phoneNumber": "4374262524"
    },
    {
        "userId": 48,
        "name": "Diann Krelle",
        "phoneNumber": "3195044558"
    },
    {
        "userId": 49,
        "name": "Antony Darnbrook",
        "phoneNumber": "7271402866"
    },
    {
        "userId": 50,
        "name": "Ellary Castlake",
        "phoneNumber": "3334853837"
    }
]

2. searchQuery = "all", no other parameters provided

Result:

[
    {
        "userId": 18,
        "name": "Laural Gallaway",
        "phoneNumber": "5637845571"
    },
    {
        "userId": 27,
        "name": "Bernice McFall",
        "phoneNumber": "6909421930"
    },
    {
        "userId": 51,
        "name": "Allina Sayle",
        "phoneNumber": "2734922658"
    },
    {
        "userId": 70,
        "name": "Hortense Barnewall",
        "phoneNumber": "1126474259"
    },
    {
        "userId": 74,
        "name": "Nessy Halliwell",
        "phoneNumber": "1738026700"
    },
    {
        "userId": 107,
        "name": "Emmaline Gronaller",
        "phoneNumber": "1032197521"
    },
    {
        "userId": 126,
        "name": "Elayne Alliot",
        "phoneNumber": "2324779022"
    },
    {
        "userId": 142,
        "name": "Tallulah Mewrcik",
        "phoneNumber": "2055298196"
    },
    {
        "userId": 146,
        "name": "Darnall Hubbins",
        "phoneNumber": "5977904036"
    },
    {
        "userId": 152,
        "name": "Udall Kingswoode",
        "phoneNumber": "1086535489"
    },
    {
        "userId": 156,
        "name": "Demetris Rastall",
        "phoneNumber": "6463791956"
    },
    {
        "userId": 178,
        "name": "Allyn Houndesome",
        "phoneNumber": "8477304761"
    },
    {
        "userId": 179,
        "name": "Elmer Balleine",
        "phoneNumber": "5888183021"
    },
    {
        "userId": 200,
        "name": "Normie Pettingall",
        "phoneNumber": "7966857634"
    }
]

3. searchQuery = "all", sortIndication = "Alphabetical", no other parameters provided

Result:

[
    {
        "userId": 51,
        "name": "Allina Sayle",
        "phoneNumber": "2734922658"
    },
    {
        "userId": 178,
        "name": "Allyn Houndesome",
        "phoneNumber": "8477304761"
    },
    {
        "userId": 27,
        "name": "Bernice McFall",
        "phoneNumber": "6909421930"
    },
    {
        "userId": 146,
        "name": "Darnall Hubbins",
        "phoneNumber": "5977904036"
    },
    {
        "userId": 156,
        "name": "Demetris Rastall",
        "phoneNumber": "6463791956"
    },
    {
        "userId": 126,
        "name": "Elayne Alliot",
        "phoneNumber": "2324779022"
    },
    {
        "userId": 179,
        "name": "Elmer Balleine",
        "phoneNumber": "5888183021"
    },
    {
        "userId": 107,
        "name": "Emmaline Gronaller",
        "phoneNumber": "1032197521"
    },
    {
        "userId": 70,
        "name": "Hortense Barnewall",
        "phoneNumber": "1126474259"
    },
    {
        "userId": 18,
        "name": "Laural Gallaway",
        "phoneNumber": "5637845571"
    },
    {
        "userId": 74,
        "name": "Nessy Halliwell",
        "phoneNumber": "1738026700"
    },
    {
        "userId": 200,
        "name": "Normie Pettingall",
        "phoneNumber": "7966857634"
    },
    {
        "userId": 142,
        "name": "Tallulah Mewrcik",
        "phoneNumber": "2055298196"
    },
    {
        "userId": 152,
        "name": "Udall Kingswoode",
        "phoneNumber": "1086535489"
    }
]

4. searchQuery = "all", sortIndication = "Alphabetical", pageSize = 3, no other parameters provided

Result:

[
    {
        "userId": 51,
        "name": "Allina Sayle",
        "phoneNumber": "2734922658"
    },
    {
        "userId": 178,
        "name": "Allyn Houndesome",
        "phoneNumber": "8477304761"
    },
    {
        "userId": 27,
        "name": "Bernice McFall",
        "phoneNumber": "6909421930"
    }
]

5. searchQuery = "all", sortIndication = "Alphabetical", pageSize = 3, pageNumber = 2

Result:

[
    {
        "userId": 146,
        "name": "Darnall Hubbins",
        "phoneNumber": "5977904036"
    },
    {
        "userId": 156,
        "name": "Demetris Rastall",
        "phoneNumber": "6463791956"
    },
    {
        "userId": 126,
        "name": "Elayne Alliot",
        "phoneNumber": "2324779022"
    }
]

6. searchQuery = "all", sortIndication = "Alphabetical", pageSize = 3, pageNumber = 99

Since 99 is greater than the number of pages retrieved, it will retrieve the last page found.
Since 3 is greater than the number of results on that page, it will display all of them (2 in this case).

Result:

[
    {
        "userId": 142,
        "name": "Tallulah Mewrcik",
        "phoneNumber": "2055298196"
    },
    {
        "userId": 152,
        "name": "Udall Kingswoode",
        "phoneNumber": "1086535489"
    }
]

*Known Errors*

1. If a non-integer value is provided as either pageSize or pageNumber, a status code 400 will be received
   with a "MethodArgumentTypeMismatchException".

*Contact*

For further questions, please contact Seth Post at sethapost@gmail.com

---THANK YOU---

