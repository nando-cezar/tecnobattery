import React from 'react';
import { Center, Link, SimpleGrid, Text } from '@chakra-ui/react'

import db from '../../../../db.json'

import YouTubeIcon from '../../../assets/youtube.svg'
import InstagramIcon from '../../../assets/instagram.svg'
import LinkedinIcon from '../../../assets/linkedin.svg'

const Footer: React.FC = () => {
  return (
    <footer>
      <SimpleGrid columns={1}>
        <Center>
          <Text fontSize="md">
            {db.footer}
          </Text>
        </Center>
        <Center marginTop={2}>
          <SimpleGrid columns={3} spacing={10}>
            <Link href="#" >
              <YouTubeIcon />
            </Link>
            <Link href="#" >
              <LinkedinIcon />
            </Link>
            <Link href="#" >
              <InstagramIcon />
            </Link>
          </SimpleGrid>
        </Center>
      </SimpleGrid>
    </footer>
  );
}

export default Footer;