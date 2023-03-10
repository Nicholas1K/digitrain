import React from "react";
import { Box, Typography, Button } from "@mui/material";
import logo from "../assets/train.svg";
import Layout from "../components/Layout";
import { useNavigate } from "react-router-dom";

const Welcome = () => {
  const navigate = useNavigate();

  return (
    <Layout>
      <Box mb={3}>
        <Typography variant="h1" component="h4" align="center">
          digitatrain
        </Typography>
        <Typography align="center" variant="h1">
          {"<"}
          <img src={logo} alt="logo" style={{ fill: "white" }} />
          {"/>"}
        </Typography>
        <Typography align="center" variant="h6" component="h6">
          Ti porta verso i tuoi sogni!
        </Typography>
      </Box>

      <Box sx={{ textAlign: "center" }}>
        <Button variant="contained" onClick={() => navigate("/prenota")}>
          prenota
        </Button>
      </Box>
    </Layout>
  );
};

export default Welcome;
