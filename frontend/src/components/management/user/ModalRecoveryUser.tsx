import React from 'react';
import { Button, Link, Modal, ModalBody, ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay, useDisclosure } from '@chakra-ui/react'

import Input from '../../application/customized/Input';

const ModalRecoveryUser: React.FC = () => {

  const { isOpen, onOpen, onClose } = useDisclosure()

  return (
    <>
      <Link
        alignSelf="flex-start"
        marginTop={2}
        fontSize="sm"
        color="red.600"
        fontWeight="bold"
        _hover={{ color: 'red.500' }}
        onClick={onOpen}
      >
        Esqueci minha senha
      </Link>
      <Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Recupere sua conta</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <Input
              placeholder='Digite seu e-mail'
              type='email'
            />
          </ModalBody>
          <ModalFooter aliignItems='center'>
            <Button
              height="50px"
              flex="1"
              backgroundColor="gray.600"
              borderRadius="sm"
              _hover={{ backgroundColor: 'red.500' }}

            >
              Solicitar
            </Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  );
}

export default ModalRecoveryUser;
