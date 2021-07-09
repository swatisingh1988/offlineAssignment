# OffLine Assignment 

## Task 1
### Markdown Headers
MarkDown controller
Task shall be accompanied with unit tests proving the solution.<br/>
Background
Markdown is a formatting syntax used by many documents (these instructions, for example!) because of it's plain-text simplicity and its ability to be translated directly into HTML.<br/>


Task<br/>
<br/>Let's write a simple markdown parser function that will take in a single line of markdown and be translated into the appropriate HTML. <br/>To keep it simple, we'll support only one feature of markdown in atx syntax: headers.
Headers are designated by (1-6) hashes followed by a space, followed by text. The number of hashes determines the header level of the HTML output.<br/>
Examples :
`# Header will become "<h1>Header</h1>`
 `## Header will become <h2>Header</h2>`
 `###### Header will become <h6>Header</h6>`

####Additional Rules
Header content should only come after the initial hashtag(s) plus a space character.<br/>
Invalid headers should just be returned as the markdown that was received, no translation necessary.<br/>
Spaces before and after both the header content and the hashtag(s) should be ignored in the resulting output.<br/>

## Task 2
### Spring: JSON Articles API
ArticleController<br/>

Spring: JSON Articles API<br/>
In this challenge we're going to build an API for CRUD operations over articles using Spring MVC.<br/>
API shall be able to<br/>
• Retrieve article by unique identifier<br/>
• Retrieve articles for any calendar day sorted by article date created in descending order<br/>
• Create article<br/>
• Modify article<br/>
• Delete article (only if it is more than 1 year old) The endpoints should accept and return JSON representations of Article.<br/>
Offline assignment Page 2<br/>
Article has a Title (maximum of 64 symbols length) and a Body (any length).<br/>
Data storage for the articles should be any simple in-memory structure (it gets flushed if the application restarted).<br/>
No JPA and 3rd party libraries except spring-boot to be used.<br/>

## Task 3<br/>
### Object-oriented programming, OOP Challenge
MockCommentController<br/>

Object-oriented programming, OOP Challenge<br/>
For this challenge, you are going to build a mock comments section.<br/>
Your Challenge<br/>
This is challenge is not about building a fully functional API, but more about focusing on the design from an object-oriented point-of-view. Keep in mind encapsulation.<br/>
Solution needs to demonstrate how the requirements from API section have been fulfilled.<br/>
Design
We're going to focus on two aspects:
Users
• Users can create comments<br/>
• Users come in 3 flavors: normal users, moderators, and admins.<br/>
• Normal user can only create new comments, edit his own comments and delete replies to his own comments.<br/>
• Moderators cannot create new comments but have the ability to delete any comment (to remove trolls)<br/>
• Admins can create new comments, edit or delete any comment.<br/>
• Users can log in and out, and we track when they last logged in<br/>
Comments<br/>
• Comments are simply a message, a timestamp, and the author.<br/>
• Comments can also be a reply. • When converting to a string (toString), the following format is used:<br/>
o No replied to:<br/>
Offline assignment Page 3<br/>
"$message by ${author->name}" o With replied to:<br/>
"$message by ${author->name} (replied to ${repliedTo->author->name})"<br/>
API<br/>
It should be possible to create a user and a comment for any given user.<br/>
For any user it should be possible<br/>
• Determine the last he logged in<br/>
• To check if this user is able to edit and delete any given comment<br/>
For any comment it should be possible to find out the original comment having been replied to.<br/>

### Author
Swati Singh
