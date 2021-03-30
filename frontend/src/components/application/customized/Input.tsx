import React from 'react';
import { Input as ChakraInput, InputProps as ChakraInputProps } from '@chakra-ui/react'

const Input: React.FC<ChakraInputProps> = (props) => {
  return (
    <ChakraInput
      autoComplete="new-password"
      marginTop={2} size="md"
      height="50px"
      backgroundColor="gray.800"
      focusBorderColor="red.500"
      borderRadius="sm"
      {...props}
    />
  )
}

export default Input;