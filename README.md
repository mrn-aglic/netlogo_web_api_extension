# netlogo_web_api_extension
Here, I have made a small proof of concept extension for NetLogo. It is based on the sample-scala extension that comes with NetLogo 6.0-M5 and needs the same version to run. The extension embeds a jetty server with a lift application in order to provide an API endpoint. I have done this because of the existence of some personal .NET projects that could benefit from interoperability with NetLogo and I saw this as the simplest way to achieve interoperability

The extension has been tested with the following code:

```netlogo
extensions [sample-scala]
 
 to test
  
  sample-scala:setup 9090
  sample-scala:start
  
end 
```

In the command line: 
``` sample-scala:putdata 5 ```

Navigating to localhost:9090/api/test produces the expected JSON result :-) 

However, an exception occurs internali which I have noticed because I started NetLogo 6.0-M5 from source:

``` java.lang.ClassNotFoundException: org.eclipse.jetty.servlet.listener.ELContextCleaner ```

and 

``` java.lang.ClassNotFoundException: org.eclipse.jetty.servlet.listener.IntrospectorCleaner ```

and I am unsure why. 

Here are links to some of the resources I used:
1. http://stackoverflow.com/questions/11387612/serialize-a-map-that-doesnt-have-a-string-as-a-key-with-lift-json  
2. https://github.com/joescii/lift-jetty-cluster/blob/master/src/main/scala/bootstrap/liftweb/Start.scala  



Here I include the details of the Readme that came with the sample scala extension: 

# NetLogo sample Scala extension

This is a very small example NetLogo extension, written in Scala.

## Building

Run the `bin/sbt` script to build the extension.

If the build succeeds, `sample-scala.jar` is created.

## Terms of Use

[![CC0](http://i.creativecommons.org/p/zero/1.0/88x31.png)](http://creativecommons.org/publicdomain/zero/1.0/)

The NetLogo sample Scala extension is in the public domain.  To the extent possible under law, Uri Wilensky has waived all copyright and related or neighboring rights.