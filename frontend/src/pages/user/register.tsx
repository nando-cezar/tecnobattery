import React from 'react'

import { Heading, Grid, Flex, Link, Button, Text } from '@chakra-ui/react'

import Input from '../../components/Input'

import TecnobatteryLogo from '../../assets/tecnobattery.svg'

import InputPassword from '../../components/InputPassword'

import InputPhoneNumber from './../../components/InputPhoneNumber';

export default function Register() {

  return (
    <Grid
      as="main"
      height="100vh"
      templateColumns="1fr 480px 480px 1fr"
      templateRows="1fr 480px 1fr"
      templateAreas="
        '. . . .'
        '. logo form .'
        '. . . .'
      "
      justifyContent="center"
      alignItems="center"
    >
      <Flex gridArea="logo" flexDir="column" alignItems="flex-start">
        <Link
          href="/"
          _focus={{ border: 'none' }}
        >
          <TecnobatteryLogo />
        </Link>


        <Heading size="2xl" lineHeight="shorter" marginTop={16}>
          Faça parte do nosso time
        </Heading>
      </Flex>

      <Flex
        gridArea="form"
        height="100%"
        backgroundColor="gray.700"
        borderRadius="md"
        flexDir="column"
        alignItems="stretch"
        padding={16}
      >
        <Input
          placeholder="Nome de usuário"
          type="text"
        />

        <InputPassword />

        <Input
          placeholder="E-mail"
          type="email"
        />

        <InputPhoneNumber/>

        <Button
          backgroundColor="red.500"
          height="50px"
          borderRadius="sm"
          marginTop={6}
          _hover={{ backgroundColor: 'red.600' }}

        >
          REGISTRAR
        </Button>

        <Text
          textAlign="center"
          fontSize="sm"
          color="gray.300"
          marginTop={6}
        >
          Já possui uma conta? {" "}
          <Link
            color="red.600"
            fontWeight="bold"
            _hover={{ color: 'red.500' }}
            href="/user/authentication"
            _focus={{ border: 'none' }}
          >
            Faça seu login
          </Link>
        </Text>
      </Flex>
    </Grid>
  )
}
