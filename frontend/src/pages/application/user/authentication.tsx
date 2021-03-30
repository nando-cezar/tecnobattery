import React, { useEffect, useState } from 'react'

import { Heading, Grid, Flex, Link, Button, Text, useDisclosure, AlertDialog, AlertDialogOverlay, AlertDialogContent, AlertDialogHeader, AlertDialogCloseButton, AlertDialogBody, AlertDialogFooter } from '@chakra-ui/react'
import Divider from '../../../components/application/customized/Divider'
import Input from '../../../components/application/customized/Input'
import TecnobatteryLogo from '../../../assets/tecnobattery.svg'
import InputPassword from '../../../components/application/customized/InputPassword'
import router from 'next/router'
import DrawerRegister from '../../../components/management/user/DrawerRegister'
import { authenticationUser } from '../../../connection/api'
import SpinnerChakra from '../../../components/application/actions/SpinnerChakra'

export default function Authentication() {

  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState()
  const { isOpen, onOpen, onClose } = useDisclosure()
  const cancelRef = React.useRef()

  useEffect(() => {
    const timer = setTimeout(() => {
      setLoading(false);
    }, 3000);
    return () => clearTimeout(timer);
  }, [])

  const handleSubmit = (event) => {

    event.preventDefault();

    authenticationUser(username, password)
      .then(response => {
        localStorage.setItem("Authorization", response.data)
        router.push('/application/management/dashboard')
      })
      .catch(error => {
        setError(error.response.data)
        onOpen
      })
  }

  return (
    <>
      {loading && <SpinnerChakra />}
      {!loading &&
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
              Faça seu login na plataforma
            </Heading>
          </Flex>
          {error != null &&
            
            <AlertDialog
              motionPreset="slideInBottom"
              leastDestructiveRef={cancelRef}
              onClose={onClose}
              isOpen={isOpen}
              isCentered
            >
              <AlertDialogOverlay />

              <AlertDialogContent>
                <AlertDialogHeader>Messagem</AlertDialogHeader>
                <AlertDialogCloseButton />
                <AlertDialogBody>
                  {error}
              </AlertDialogBody>
                <AlertDialogFooter>
                  <Button ref={cancelRef} onClick={onClose}>
                    Ok
                </Button>
                </AlertDialogFooter>
              </AlertDialogContent>
            </AlertDialog>
          }
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
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />

            <InputPassword
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />

            <Link
              alignSelf="flex-start"
              marginTop={2}
              fontSize="sm"
              color="red.600"
              fontWeight="bold"
              _hover={{ color: 'red.500' }}
            >
              Esqueci minha senha
        </Link>

            <Button
              backgroundColor="red.500"
              height="50px"
              borderRadius="sm"
              marginTop={6}
              _hover={{ backgroundColor: 'red.600' }}
              onClick={handleSubmit}
            >
              ENTRAR
        </Button>

            <Text
              textAlign="center"
              fontSize="sm"
              color="gray.300"
              marginTop={6}
            >
              Não tem uma conta? {" "}
              <DrawerRegister />
            </Text>

            <Divider />

            <Flex alignItems="center">
              <Text fontSize="sm">Ou entre com</Text>
              <Button
                height="50px"
                flex="1"
                backgroundColor="gray.600"
                marginLeft={6}
                borderRadius="sm"
                _hover={{ backgroundColor: 'red.500' }}
              >
                FACEBOOK
          </Button>
            </Flex>
          </Flex>
        </Grid>
      }
    </>
  )
}
