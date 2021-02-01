Tech choices:

Koin - Low boilerplate alternative to Dagger with good support for ViewModel injection.

Retrofit - Commonly used and understood library for making API calls with support for RxJava.

OkHttpClient - Default HTTP client for Retrofit, provides easy to plug integrations like logging.

GSON - JSON parser with easy to plug integration into Retrofit.

RxJava 2 - Standard library for managing threading. Provides functionality to easily compose multiple sources and
           manipulate the output as required (e.g. filter, map). Choosing over 3.0 or coroutines due to familiarity.

Android ViewModel - Library for implementing "presenter" type classes, abstracts complex lifecycle and
                    state data management.

Android LiveData - Lifecycle aware "observable", abstracts handling of [un]subscription based on view's lifecycle.

Android Navigation - Low boilerplate navigation solution when custom backstack manipulation is not required.
                     Abstracts handling of Toolbar & BottomNavigationBar, etc.