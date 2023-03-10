import React from "react";
import api from "../api";
import Layout from "../components/Layout";
import { Box, Typography, Alert, Paper, Grid, Button } from "@mui/material";
import { isEmpty } from "lodash";
import { useNavigate } from "react-router-dom";

export default function Prenotazioni() {
  const navigate = useNavigate();

  const [prenotazioni, setPrenotazioni] = React.useState();

  React.useEffect(() => {
    api
      .get("/reservation/all")
      .then((res) => setPrenotazioni(res.data))
      .catch((err) => console.log(err));
  }, []);

  if (prenotazioni) {
    return (
      <>
        <Layout>
          <Box mb={3}>
            <Typography variant="h3" component="h4">
              Prenotazioni
            </Typography>
          </Box>

          {isEmpty(prenotazioni) && (
            <Alert severity="warning">Non ci sono prenotazioni</Alert>
          )}

          {!isEmpty(prenotazioni) && (
            <>
              {prenotazioni.map((p) => (
                <Box mb={3} key={p.id}>
                  <Paper>
                    <Box p={2}>
                      <Typography variant="h6" gutterBottom>
                        {p.passenger.name}
                      </Typography>

                      <Grid
                        container
                        direction="row"
                        justifyContent="space-around"
                        alignItems="center"
                        spacing={2}
                      >
                        <Grid item xs={5}>
                          <Typography variant="overline">
                            {p.travels.departureTime.split("T").join(" ")}
                          </Typography>
                          <Typography variant="h6">
                            {p.travels.departureCity}
                          </Typography>
                        </Grid>

                        <Grid item xs={5}>
                          <Typography variant="overline">
                            {p.travels.arrivalTime.split("T").join(" ")}
                          </Typography>
                          <Typography variant="h6">
                            {p.travels.arrivalCity}
                          </Typography>
                        </Grid>
                        <Grid item xs={2}>
                          <Button
                            onClick={() => navigate("/prenotazione/" + p.id)}
                          >
                            Dettagli
                          </Button>
                        </Grid>
                      </Grid>
                    </Box>
                  </Paper>
                </Box>
              ))}
            </>
          )}
        </Layout>
      </>
    );
  }
}
