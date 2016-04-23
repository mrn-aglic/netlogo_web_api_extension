# netlogo_web_api_extension
Here, I have made a small proof of concept extension for NetLogo. It is based on the sample-scala extension that comes with NetLogo 6.0-M5 and needs the same version to run. The extension embeds a jetty server with a lift application in order to provide an API endpoint. I have done this because of the existence of some personal .NET projects that could benefit from interoperability with NetLogo and I saw this as the simplest way to achieve interoperability

Here I include the details of the Readme that came with the sample scala extension: 

# NetLogo sample Scala extension

This is a very small example NetLogo extension, written in Scala.

## Building

Run the `bin/sbt` script to build the extension.

If the build succeeds, `sample-scala.jar` is created.

## Terms of Use

[![CC0](http://i.creativecommons.org/p/zero/1.0/88x31.png)](http://creativecommons.org/publicdomain/zero/1.0/)

The NetLogo sample Scala extension is in the public domain.  To the extent possible under law, Uri Wilensky has waived all copyright and related or neighboring rights.