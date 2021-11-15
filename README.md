# Feature flags into our Android App

Gradually, mobile application development teams are looking to provide more functionalities for their users, more reliable code and agility to deploy their applications, therefore, software development tools are evolving day by day.

One of the best ways to provide greater automation and lower risks is to incorporate Feature Flags in our projects.


<h2> :triangular_flag_on_post: What is a Feature Flag?</h2>
Feature flags are a great software technique which allow software development teams to modify the behaviour of the application without changing the code. They only need change a flag remotely and it updates this variable in the production application. This allows developers to take control of the release of their features and remove features that don't work well once released to the Google Play Store (production app).

There are many advantages to incorporating this software technique into our code, but from my point of view, the most important is peace of mind and reliability of the code. When uploading a new feature to production, in the event that it starts to fail, we can quickly deactivate this functionality and make the user go for the previous functionality that we know definitely works. It is a winwin; the development team can implement new functionalities and also have a contingency method that allows the user to continue using the functionality in case of error.


<h2> :raised_hands: What are the advantages of implementing Feature Flags in our project?</h2>
<b>Invisibility</b>: Feature flags allow you to launch new features that are still under development. Since each new feature is behind a toggle, it will not become visible until you decide to activate it.

<b>Speed and flexibility</b>: Bugs are also dealt with more efficiently: if someone finds a bug with a feature behind a toggle, you can immediately switch it to off. So, there is less pressure to try to get everything right first time.

<b>A/B Testing</b>: Feature toggles are a good way to facilitate experimentation, test ideas and check what is best for your users.

<b>Risk reduction and security</b>: You can revert your product or functionality immediately if you detect a bug or receive negative feedback. So, you could test your new features in production while collecting feedback from users.

<h2> 💪: How do we implement it? - Hey, Ho! Let’s go!</h2>
There are several ways to implement a Feature Flag, in my opinion, the ideal way would be to have these flags remotely and update them in our local device, to avoid making many calls to the API service.

One way to develop it would be to make a call to our API service that would return a JSON object where all our feature flags values are stored, and when we start the application we could load and store them locally.

Another way to implement it would be through the Firebase Remote Config tool and SharedPreferences to store our Feature Flags locally. For this article I chose the last option because Firebase Remote Config is a great tool. To do that, I used the following steps:

1. Import Firebase Remote Config library in your project

2. Create a CLEAN structure project, MVVM architecture. In my case I created a view, domain, data layer.
- Data: Repository and DataSource class
- Domain: UseCase class
- View layer: Fragment and ViewModel class

<h2> :checkered_flag:  Conclusion</h2>
The feature flags usage can help companies deliver more frequently, minimise risk, increase productivity and even help target certain users and A/B test functionalities.

I can assure you that when you start implementing feature flags in your project, they will give you so much peace of mind that from that moment on you will not be able to upload a new feature without its associated flag.

At Tymit we love sharing our knowledge and it pleases us greatly to have shared this story with you. We hope that it can serve as inspiration for coming up with a solution that adapts to your own needs.

