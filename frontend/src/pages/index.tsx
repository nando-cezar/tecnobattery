import React from 'react'
import Head from 'next/head'

import { Container } from '../styles/pages/Home'

import TecnobatteryLogo from '../assets/tecnobattery.svg'

const Home: React.FC = () => {
  return (
    <Container>
      <Head>
        <title>Homepage</title>
      </Head>

      <TecnobatteryLogo />
      <h1>Tecnobattery Eletronics</h1>
      <p>Procure a oportunidade de energizar o seu negócio agora.</p>
    </Container>
  )
}

export default Home
