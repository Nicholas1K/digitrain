import { Box, Container } from "@mui/material";
import React from "react";

const Layout = ({ children }) => {
  return (
    <>
      <Container>
        <Box mt={3} pb={3}>
          {children}
        </Box>
      </Container>
    </>
  );
};

export default Layout;
