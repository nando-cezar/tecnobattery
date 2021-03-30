import React from "react"

import { ChakraProvider } from "@chakra-ui/react"
import themeChakra from "../styles/theme"
import Head from 'next/head'
import db from '../../db.json'

function MyApp({ Component, pageProps }) {
  return (
    <ChakraProvider theme={themeChakra}>
      <Head>
        <title>{db.title}</title>
      </Head>
      <Component {...pageProps} />
    </ChakraProvider>
  )
}

export default MyApp
