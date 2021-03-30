import React from 'react'
import Head from 'next/head'

import { Flex, Grid, Link, Text } from '@chakra-ui/react'

import db from '../../db.json'

import TecnobatteryLogo from '../assets/tecnobattery.svg'
import Footer from '../components/application/structure/Footer'


const Home: React.FC = () => {
  return (
    <>
      <Grid
        as="main"
        height="100vh"
        templateColumns="20px 1fr 20px"
        templateRows="40px 1fr 2fr 0.5fr"
        templateAreas="
            '. . .'
            '. logo .'
            '. description .'
            '. footer .'
          "
        justifyContent="center"
        alignItems="center"
      >
        <Flex gridArea="logo" flexDir="column" alignItems="center">
          <TecnobatteryLogo />
        </Flex>
        <Flex gridArea="description" flexDir="column" alignItems="center">
          <Text fontSize={["sm", "md", "lg", "xl"]}>
            {db.subtitle}
          </Text>
          <Link
            href="application/user/authentication"
            alignSelf="flex"
            marginTop={2}
            fontSize={["sm", "md", "lg", "xl"]}
            color="red.500"
            _hover={{ color: 'red.600' }}
            _focus={{ border: 'none' }}
          >
            {db.subtitleIndex}
          </Link>
        </Flex>
        <Flex gridArea="footer" flexDir="column" alignItems="center">
          <Footer />
        </Flex>
      </Grid>
    </>
  )
}

export default Home
