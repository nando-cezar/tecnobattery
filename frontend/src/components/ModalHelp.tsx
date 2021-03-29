import React from 'react';
import { Button, IconButton, Modal, ModalBody, ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay, useDisclosure } from '@chakra-ui/react'

import db from '../../db.json'
import { InfoIcon } from '@chakra-ui/icons';

const ModalHelp: React.FC = () => {

  const { isOpen, onOpen, onClose } = useDisclosure()

  return (
    <>
      <IconButton
        size="md"
        variant="outline"
        aria-label="Options"
        icon={<InfoIcon />}
        onClick={onOpen}
      />
      <Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Help</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            {db.helper}
          </ModalBody>

          <ModalFooter>
            <Button colorScheme="blue" mr={3} onClick={onClose}>
              Close
            </Button>
            <Button variant="ghost">Secondary Action</Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  );
}

export default ModalHelp;
