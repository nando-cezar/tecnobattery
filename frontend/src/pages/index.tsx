import React from 'react'
import Head from 'next/head'

import { Container } from '../styles/pages/Home'

import TecnobatteryLogo from '../assets/tecnobattery.svg'

import { Button, Link, useColorMode } from '@chakra-ui/react'

const Home: React.FC = () => {

  const { colorMode, toggleColorMode } = useColorMode()

  return (
    <>
      <Container>
        <Head>
          <title>Homepage</title>
        </Head>
        <header>
          <Button onClick={toggleColorMode}>
            Toggle {colorMode === "light" ? "Dark" : "Light"}
          </Button>
        </header>
        <TecnobatteryLogo />
        <h1>Tecnobattery Eletronics</h1>
        <Link
          href="/user/authentication"
          alignSelf="flex"
          marginTop={2}
          fontSize={20}
          color="red.500"
          _hover={{ color: 'red.600' }}
          _focus={{ border: 'none' }}
        >
          Clique aqui, e procure a oportunidade perfeita para energizar o seu negócio.
        </Link>
      </Container>
    </>
  )
}

export default Home
