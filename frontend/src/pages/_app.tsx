import React from "react"

import { ChakraProvider } from "@chakra-ui/react"
import themeChakra from "../styles/theme"


function MyApp({ Component, pageProps }) {
  return (
    <ChakraProvider theme={themeChakra}>
      <Component {...pageProps} />
    </ChakraProvider>
  )
}

export default MyApp
