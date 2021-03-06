package com.example.demo.controller;

import java.util.List;

import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.model.entities.ActingSubstance;
import com.example.demo.services.interfaces.IActingSubstancesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/acting_substances")
public class ActingSubstancesController {
  @Autowired
  private IActingSubstancesService actingSubstancesService;

  @GetMapping
  public ResponseEntity<List<ActingSubstance>> getDrugs(
      @RequestParam(name = "skip", defaultValue = "0", required = false) Integer skip,
      @RequestParam(name = "take", defaultValue = "20", required = false) Integer take) {
    var substances = actingSubstancesService.getPage(skip, take);
    return new ResponseEntity<>(substances, HttpStatus.OK);
  }

  // @GetMapping("/{drugId}")
  // public ResponseEntity<ActingSubstanceContract>
  // getDrugById(@PathVariable("drugId") Long drugId) {
  // var drug = drugService.getById(drugId);
  // return new ResponseEntity<>(DrugContract.fromDrug(drug), HttpStatus.FOUND);
  // }

  // @PostMapping
  // public ResponseEntity<DrugContract> createDrug(@RequestBody DrugContract
  // drugContract) {
  // return new
  // ResponseEntity<>(DrugContract.fromDrug(drugService.createDrug(drugContract)),
  // HttpStatus.CREATED);
  // }

  @GetMapping("/brief")
  public ResponseEntity<List<ActingSubstanceOrDrugBriefContract>> getBriefDrugs(@RequestParam("search") String search) {
    var brief = actingSubstancesService.getBrief(search);
    return new ResponseEntity<>(brief, HttpStatus.OK);
  }

  // Map<String, UserRest> users = new HashMap<>();

  // public DrugsController() {
  // for (int i = 0; i < 100; i++) {
  // UserRest user = new UserRest();
  // user.setEmail(String.format("user%d@example.com", i));
  // user.setUserName(String.format("User #%d", i));
  // user.setUserId(UUID.randomUUID().toString());
  // this.users.put(user.getUserId(), user);
  // }
  // }

  // @GetMapping
  // public UserRest[] getUsers(@RequestParam(value = "take", required = false,
  // defaultValue = "50") Integer take,
  // @RequestParam(value = "skip", required = false, defaultValue = "0") Integer
  // skip) {
  // // Dumb implementation of a comparator because this is a demo. In a real
  // world
  // // situation there'd be a database.
  // return this.users.values().stream()
  // .sorted((a, b) -> ((Integer) Integer.parseInt(a.getUserName().split("#")[1]))
  // .compareTo((Integer) Integer.parseInt(b.getUserName().split("#")[1])))
  // .skip(skip).limit(take).toArray(UserRest[]::new);
  // }

  // @GetMapping(path = "/{userId}")
  // public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
  // if (this.users.containsKey(userId)) {
  // return new ResponseEntity<UserRest>(this.users.get(userId), HttpStatus.OK);
  // }
  // return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
  // }

  // @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  // public ResponseEntity<UserRest> createUser(@Valid @RequestBody
  // UserRequestModel userDetails) {
  // var user = new UserRest(userDetails);
  // user.setUserId(UUID.randomUUID().toString());
  // this.users.put(user.getUserId(), user);
  // return new ResponseEntity<UserRest>(user, HttpStatus.CREATED);
  // }

  // @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
  // MediaType.APPLICATION_JSON_VALUE, path = "/{userId}")
  // public ResponseEntity<UserRest> updateUser(@Valid() @RequestBody
  // UpdateUserRequestModel userDetails,
  // @PathVariable String userId) {
  // if (this.users.containsKey(userId)) {
  // var user = users.get(userId);
  // user.update(userDetails);
  // users.put(userId, user);
  // return new ResponseEntity<UserRest>(user, HttpStatus.OK);
  // }
  // return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
  // }

  // @DeleteMapping(path = "/{userId}")
  // public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
  // if (this.users.containsKey(userId)) {
  // this.users.remove(userId);
  // return ResponseEntity.noContent().build();
  // }
  // return ResponseEntity.notFound().build();
  // }
}
