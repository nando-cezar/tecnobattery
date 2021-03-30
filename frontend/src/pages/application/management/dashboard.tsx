import React, { useEffect, useState } from 'react'
import Head from 'next/head'

import styled from 'styled-components'

import { Flex, Link } from '@chakra-ui/react'

import db from '../../../../db.json'

import TecnobatteryLogo from '../../../assets/tecnobattery.svg'
import Footer from '../../../components/application/structure/Footer'
import Header from '../../../components/application/structure/Header'
import SpinnerChakra from '../../../components/application/actions/SpinnerChakra'


const Container = styled.div`
  width: 100vw;
  height: 80vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  h1 {
    font-size: 54px;
    margin-top: 40px;
  }

`;

const Dashboard: React.FC = () => {

  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const timer = setTimeout(() => {
      setLoading(false);
    }, 3000);
    return () => clearTimeout(timer);
  }, [])

  return (
    <>
      <Head>
        <title>{db.title}</title>
      </Head>
      {loading && <SpinnerChakra />}
      {!loading &&
        <>
          <Header />
          <Container>
            <TecnobatteryLogo />
            <h1>{db.subtitle}</h1>
            <Link
              href="/application/user/authentication"
              alignSelf="flex"
              marginTop={2}
              fontSize={20}
              color="red.500"
              _hover={{ color: 'red.600' }}
              _focus={{ border: 'none' }}
            >
              {db.subtitleIndex}
            </Link>
          </Container>
          <Footer />
        </>
      }
    </>
  )
}

export default Dashboard
