import React from 'react';
import {Input as ChakraInput, InputGroup, InputLeftAddon, InputProps as ChakraInputProps, InputRightElement } from '@chakra-ui/react'

const InputPhoneNumber: React.FC<ChakraInputProps> = (props) => {

  const [show, setShow] = React.useState(false)
  const handleClick = () => setShow(!show)

  return (

    <InputGroup marginTop={2} size="md">
      <InputLeftAddon height="50px" children="+234" />
      <ChakraInput
        height="50px"
        backgroundColor="gray.800"
        focusBorderColor="red.500"
        borderRadius="sm"
        placeholder="Número de telefone"
        type="tel"
        {...props}
      />
    </InputGroup>
  )
}

export default InputPhoneNumber;