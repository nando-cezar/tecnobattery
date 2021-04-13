import React, { useEffect, useState } from 'react'
import Head from 'next/head'

import db from '../../../../db.json'

import Header from '../../../components/application/structure/Header'
import SpinnerChakra from '../../../components/application/actions/SpinnerChakra'
import { useToast } from '@chakra-ui/react'
import router from 'next/router'
import BoxList from '../../../components/application/structure/BoxList'

const Dashboard: React.FC = () => {

  const [loading, setLoading] = useState(true)

  const toast = useToast()

  useEffect(() => {

    verifed()

    const timer = setTimeout(() => {
      setLoading(false);
    }, 3000);
    return () => clearTimeout(timer);
  }, [])

  function verifed() {
    alert(localStorage.getItem('Authorization'))
    if (localStorage.getItem('Authorization').length == 0) {
      toast({
        title: "Token inválido.",
        description: "Efetue o login novamente",
        status: "error",
        duration: 1500,
        isClosable: true,
      })
      localStorage.removeItem('Authorization')
      router.push('/')
    }
  }
  return (
    <>
      <Head>
        <title>{db.title}</title>
      </Head>
      {loading && <SpinnerChakra />}
      {!loading &&
        <>
          <Header />
          <BoxList />
        </>
      }
    </>
  )
}

export default Dashboard
