import React from 'react';
import { Button, Drawer, DrawerBody, DrawerCloseButton, DrawerContent, DrawerFooter, DrawerHeader, DrawerOverlay, IconButton, Link, useDisclosure } from '@chakra-ui/react'

import db from '../../../../db.json'
import { SettingsIcon } from '@chakra-ui/icons';
import Input from '../../application/customized/Input';
import InputPassword from '../../application/customized/InputPassword';
import InputPhoneNumber from '../../application/customized/InputPhoneNumber';

const DrawerRegister: React.FC = () => {

  const { isOpen, onOpen, onClose } = useDisclosure()
  const btnRef = React.useRef()

  return (
    <>
      <Link
        color="red.600"
        fontWeight="bold"
        _hover={{ color: 'red.500' }}
        ref={btnRef}
        onClick={onOpen}
        _focus={{ border: 'none' }}
      >
        Registre-se
          </Link>
      <Drawer
        isOpen={isOpen}
        placement="right"
        onClose={onClose}
        finalFocusRef={btnRef}
      >
        <DrawerOverlay>
          <DrawerContent>
            <DrawerHeader>Crie sua conta</DrawerHeader>

            <DrawerBody>
              <Input
                placeholder="Nome de usuário"
                type="text"
              />
              <InputPassword />
              <Input
                placeholder="E-mail"
                type="email"
              />
              <InputPhoneNumber />
            </DrawerBody>

            <DrawerFooter>
              <Button
                height="50px"
                flex="1"
                backgroundColor="gray.600"
                borderRadius="sm"
                _hover={{ backgroundColor: 'red.500' }}

              >
                Registrar
              </Button>
            </DrawerFooter>
          </DrawerContent>
        </DrawerOverlay>
      </Drawer>
    </>
  );
}

export default DrawerRegister
