import React from 'react';
import { Button, Input as ChakraInput, InputGroup, InputProps as ChakraInputProps, InputRightElement } from '@chakra-ui/react'
import { ViewIcon, ViewOffIcon } from '@chakra-ui/icons';

const InputPassword: React.FC<ChakraInputProps> = (props) => {

  const [show, setShow] = React.useState(false)
  const handleClick = () => setShow(!show)

  return (
    
    <InputGroup marginTop={2} size="md">
    <ChakraInput
      height="50px"
      backgroundColor="gray.800"
      focusBorderColor="red.500"
      borderRadius="sm"
      placeholder="Senha"
      type={show ? "text" : "password"}
      {...props}
    />
    <InputRightElement width="4.5rem">
            <Button marginTop={2} h="1.75rem" size="sm" onClick={handleClick}>
              {show ? <ViewOffIcon />  : <ViewIcon />}
            </Button>
          </InputRightElement>
    </InputGroup>
  )
}

export default InputPassword;