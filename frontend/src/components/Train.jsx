import React from "react";
import { Grid, Typography, Paper, Box } from "@mui/material";

export default function Train({ viaggio, typeOfTrip }) {
  return (
    <Paper>
      <Box p={2}>
        <Grid
          container
          direction="row"
          justifyContent="space-around"
          alignItems="center"
          spacing={2}
        >
          <Grid item xs={3}>
            <Typography variant="overline">
              {viaggio.departureTime.split("T").join(" ")}
            </Typography>
            <Typography variant="h6">{viaggio.departureCity}</Typography>
          </Grid>

          <Grid item xs={3}>
            <Typography variant="overline">
              {viaggio.arrivalTime.split("T").join(" ")}
            </Typography>
            <Typography variant="h6">{viaggio.arrivalCity}</Typography>
          </Grid>

          <Grid item xs={3}>
            <Typography>{typeOfTrip}</Typography>
          </Grid>
        </Grid>
      </Box>
    </Paper>
  );
}
