import React from 'react'
import Head from 'next/head'

import { Container } from '../styles/pages/Home'

import TecnobatteryLogo from '../assets/tecnobattery.svg'
import { Link } from '@chakra-ui/core'

const Test: React.FC = () => {
  return (
    <>   
      <Container>
        <Head>
          <title>Homepage</title>
        </Head>
        <TecnobatteryLogo />
        <h1>Test</h1>
        <Link
          href="/login"
          alignSelf="flex"
          marginTop={2}
          fontSize={20}
          color="red.500"
          _hover={{ color: 'red.600' }}
          _focus={{ border:'none' }} 
        >
          Clique aqui, e procure a oportunidade perfeita para energizar o seu negócio.
        </Link>
      </Container>
    </>
  )
}

export default Test
