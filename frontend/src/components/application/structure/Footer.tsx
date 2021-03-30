import React from 'react';
import { Center, Flex, Grid, Link, SimpleGrid, Text } from '@chakra-ui/react'

import db from '../../../../db.json'
import { Instagram, LinkedIn, YouTube } from '@material-ui/icons';

const Footer: React.FC = () => {
  return (
    <footer>
      <Grid
        as="main"
        height="auto"
        templateColumns="1fr"
        templateRows="10px 1fr 1fr 10px"
        templateAreas="
            '.'
            'description'
            'links'
            '.'
          "
        justifyContent="center"
        alignItems="center"
      >
        <Flex gridArea="description" flexDir="column" alignItems="center">
          <Text fontSize={["sm", "md", "lg", "xl"]}>
            {db.footer}
          </Text>
        </Flex>
        <Flex gridArea="links" flexDir="column" alignItems="center">
          <SimpleGrid columns={3} spacing={10}>
            <Link href="#" >
              <YouTube />
            </Link>
            <Link href="#" >
              <LinkedIn />
            </Link>
            <Link href="#" >
              <Instagram />
            </Link>
          </SimpleGrid>
        </Flex>
      </Grid>
    </footer>
  );
}

export default Footer;